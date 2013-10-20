

# DDD Module For PlayFramework

### Support

* Abstract Entity Class
* Abstract ValueObject Class

### Install

    $ play new SampleProject
    $ vim SampleProject/conf/dependencies.yml

    require:
        - play
        - asufana -> PlayDDD [0.1,)

    repositories:
        - asufana_playmodules_github:
            type:       http
            artifact:   "https://github.com/[organisation]/PlayDDD/raw/master/dist/[module]-[revision].zip"
            contains:
                - asufana -> *

    $ play dependencies SampleProject --clearcache
    $ play eclipsify SampleProject

### How to use

- <a href="https://github.com/asufana/DDDModuleSample" target="_blank">DDDModuleSample</a>


---

*Makoto Hanafusa ( <a href="https://twitter.com/#!/asufana" target="_blank">@asufana</a> )*


