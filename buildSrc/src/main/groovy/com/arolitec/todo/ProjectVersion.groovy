package com.arolitec.todo

public class ProjectVersion{
    Integer major
    Integer minor
    Boolean release
    
    public ProjectVersion(int major, int minor){
        this.major = major
        this.minor = minor
        release = Boolean.FALSE
    }
    
    public ProjectVersion(Integer major, int minor, Boolean release){
        this.major = major
        this.minor = minor
        this.release = release
    }
    
    @Override
    String toString() {
       "$major.$minor${release ? '' : '-SNAPSHOT'}"
    }
}