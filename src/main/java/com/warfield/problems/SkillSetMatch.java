package com.warfield.problems;

/*

In a project, you have a list of required skills req_skills, and a list of people. The ith person people[i] contains a list of skills that the person has.
Consider a sufficient team: a set of people such that for every required skill in req_skills, there is at least one person in the team who has that skill. We can represent these teams by the index of each person.
* For example, team = [0, 1, 3] represents the people with skills people[0], people[1], and people[3].
Return any sufficient team of the smallest possible size, represented by the index of each person.



Example 1:
Input: req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],["nodejs","reactjs"]]
Output: [0,2]


Example 2:
Input: req_skills = ["algorithms","math","java","reactjs","csharp","aws"],
people = [["algorithms","math","java"],["algorithms","math","reactjs"],["java","csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
people =[3,3,3...]
Output: [1,2]

----

algo -> p1,p2
math -> p1,p2,p5
java -> p1,p3,p6
reactjs -> p2, p4
csharp ->p3,p4,p5
aws -> p3,p6

p1 -> 3
p2 -> 3
p3 -> 3
p4 -> 2
p5 -> 2
p6 -> 2


? Output: [p2,p3]



*/

import java.util.*;

public class SkillSetMatch {
    static List<String> reqSkills = new ArrayList<>();
    static List<List<String>> people = new ArrayList<>();

    public static void main(String args[]) {
        getInput();
        getSkillMatch(reqSkills,people);
    }

    private static void getInput() {
        reqSkills=Arrays.asList("algorithms","math","java","reactjs","csharp","aws","special");
        //[["algorithms","math","java"],["algorithms","math","reactjs"],["java","csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
        people=Arrays.asList(
                List.of("algorithms","math","java"),
                List.of("algorithms","math","reactjs"),
                Arrays.asList("java","csharp","aws"),
                Arrays.asList("reactjs","csharp"),
                Arrays.asList("csharp","math"),
                Arrays.asList("java"),
                Arrays.asList("java"),
                Arrays.asList("special")
        );
        System.out.println("Skills Required :"+reqSkills);
        System.out.println("People Skills   :"+people);
    }

    private static void getSkillMatch(List<String> reqSkills, List<List<String>> people) {
        Map<String,List<Integer>> personListThatMatchesSkills = new HashMap<>();

        for(String reqSkill:reqSkills){
            for(List<String> peopleSkillList: people){
                if(peopleSkillList.contains(reqSkill)){
                    List<Integer> personList = personListThatMatchesSkills.get(reqSkill);
                    if(personList ==null){
                        personList= new ArrayList<>();
                    }
                    personList.add(people.indexOf(peopleSkillList));
                    personListThatMatchesSkills.put(reqSkill,personList);
                }
            }
        }
        System.out.println(personListThatMatchesSkills);

        List<Set<Integer>> finalPeopleList = new ArrayList<>();
        for (int i=0;i< people.size();i++) {
            Set<Integer> set = new HashSet<>();
            for (String skill : personListThatMatchesSkills.keySet()) {
                List<Integer> peopleList = personListThatMatchesSkills.get(skill);
                int k = Math.min(i, peopleList.size()-1);
                set.add(peopleList.get(k));
            }
            finalPeopleList.add(set);
        }
        System.out.println(finalPeopleList);

        int min=people.size();
        int index=0;
        for(Set<Integer> peopleSet: finalPeopleList){
            if (peopleSet.size()<min){
                min=peopleSet.size();
                index=finalPeopleList.indexOf(peopleSet);
            }
        }
        System.out.println("The Chosen one are:"+finalPeopleList.get(index));
    }

}
