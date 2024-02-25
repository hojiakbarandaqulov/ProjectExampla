package org.example.repository;

import org.example.dto.Profile;
import org.example.enums.ProfileStep;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProfileRepository {
    public void save(Profile profile) {
        // id#name#username
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("profile.txt", true));
            printWriter.println(profile.writableString());

            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Profile> getAll() {
        try {
            Stream<String> lines = Files.lines(Path.of("profile.txt"));
            List<Profile> profileList= lines.map(s -> {
                String arr[] = s.split("#");
                Profile profile = new Profile(Long.valueOf(arr[0]));
                profile.setName(arr[1]);
                profile.setSurname(arr[2]);
                profile.setUsername(arr[3]);
                profile.setStep(ProfileStep.valueOf(arr[4]));
                profile.setPhone(arr[5]);
                return profile;
            }).collect(Collectors.toList());

            return profileList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new LinkedList<>();
    }


    public Profile getProfile(Long id) {
        Optional<Profile> optional = getAll().stream()
                .filter(profile -> profile.getId().equals(id))
                .findFirst();

        return optional.orElse(null);
    }


    public void update(Profile profile) {
        List<Profile> profileList = getAll();
        profileList.removeIf(p -> p.getId().equals(profile.getId()));
        profileList.add(profile);
        rewrite(profileList);
    }
    public void rewrite(List<Profile> list) {
        // id#name#username
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("profile.txt"));
            list.forEach(profile -> {
                printWriter.println(profile.writableString());
            });
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
