package com.gym.objects;

/**
 * Interface is used to agregate all objects to generalise id and name calls
 */
public interface HasIdAndName {

    public Long getId();
    public String getName();
    public void setName(String str);
}
