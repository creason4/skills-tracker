package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SkillsController {

    private String name;
    private String firstChoice;
    private String secondChoice;
    private String thirdChoice;

    @RequestMapping(value="", method = RequestMethod.GET)
    @ResponseBody
    public String startSkills () {
            String html = "<h1>Skills Tracker</h1>" +
                    "<h2>There are a few skills we would love to learn. See below the list!</h2>" +
                    "<ol>" +
                    "<li>Java</li>" +
                    "<li>JavaScript</li>" +
                    "<li>Python</li>" +
                    "</ol>";

            return html;
     }

     @GetMapping(value="form")
     @ResponseBody
     public String formSkills() {
            String html = "<form method='post'>" +
                    "Name:<br>" +
                    "<input type = 'text name = 'name' />"+
                    "<br>My favorite language:<br>" +
                    "<select name = 'firstChoice'>" +
                    "<option value = 'Java'>Java</option>" +
                    "<option value = 'Javascript'>JavaScript</option>" +
                    "<option value = 'Python'>Python</option>" +
                    "</select>" +
                    "<br>My second favorite language:<br>" +
                    "<select name = 'secondChoice'>" +
                    "<option value = 'Java'>Java</option>" +
                    "<option value = 'Javascript'>JavaScript</option>" +
                    "<option value = 'Python'>Python</option>" +
                    "</select>" +
                    "<br>My third favorite language:<br>" +
                    "<select name = 'thirdChoice'>" +
                    "<option value = 'Java'>Java</option>" +
                    "<option value = 'Javascript'>JavaScript</option>" +
                    "<option value = 'Python'>Python</option>" +
                    "</select><br>" +
                    "<input type = 'submit' value = 'Submit' />" +
                    "</form>";

         return html;
     }

    @PostMapping(value="form")
    @ResponseBody
    public String namePage(@RequestParam String name, @RequestParam String firstChoice, @RequestParam String secondChoice, @RequestParam String thirdChoice) {
        this.name = name;
        this.firstChoice = firstChoice;
        this.secondChoice = secondChoice;
        this.thirdChoice = thirdChoice;
        String html = "<h1>" + name + "</h1>" +
                "<ol>" +
                "<li>" + firstChoice + "</li>" +
                "<li>" + secondChoice + "</li>" +
                "<li>" + thirdChoice + "</li>" +
                "</ol>";
        return html;
    }

}
