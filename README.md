# Examples

### Simple Reactive Application
* in memory mongoDB (bootstrap loads data)


#### Might be useful for build.gradle
```

// For Java
compileOnly('org.projectlombok:lombok')


sourceSets {
    main.java.srcDirs = []
    main.kotlin.srcDirs = ['src/main/java', 'src/main/kotlin']
    main.resources.srcDirs = ['src/main/resources']
}


```  