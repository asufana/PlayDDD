package playddd.models;

import javax.persistence.*;

import org.hibernate.annotations.*;
import org.joda.time.*;

import play.db.jpa.*;

@MappedSuperclass
public abstract class Models extends GenericModel {
    
    public static final Integer DISABLE = 0;
    public static final Integer ENABLE = 1;
    
    @Id
    @GeneratedValue
    protected Long id;
    
    public Long id() {
        return id;
    }
    
    @Override
    public Object _key() {
        return id();
    }
    
    //楽観ロックカラム
    @Version
    protected Long version;
    
    @Column(nullable = false)
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    protected DateTime createDate;
    
    public DateTime createDate() {
        return createDate;
    }
    
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    protected DateTime modifyDate;
    
    public DateTime modifyDate() {
        return modifyDate;
    }
    
    @Column(nullable = false)
    protected int disable = DISABLE;
    
    public boolean isDisable() {
        return disable == DISABLE
                ? false
                : true;
    }
    
    public void enable() {
        disable = DISABLE;
    }
    
    public void disable() {
        disable = ENABLE;
    }
    
    @PrePersist
    protected void prePersist() {
        createDate = new DateTime();
    }
    
    @PreUpdate
    protected void preUpdate() {
        modifyDate = new DateTime();
    }
    
    @Override
    public <T extends JPABase> T save() {
        if (isSatisfied() == false) {
            throw new RuntimeException();
        }
        _save();
        return (T) this;
    }
    
    /** エンティティが仕様を満たしているかどうか */
    public abstract boolean isSatisfied();
    
}
