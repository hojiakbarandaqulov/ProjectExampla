package org.example.component;

import org.example.dto.Profile;

import java.util.HashMap;
import java.util.Map;

public class ComponentContainer {
    public static Map<Long, Profile> profileMap = new HashMap<>();


    public static Profile getProfile(Long id) {
        if (profileMap.containsKey(id)) {
            return profileMap.get(id);
        } else {
            Profile profile = new Profile(id);
            profileMap.put(id, profile);
            return profile;
        }
    }
}
