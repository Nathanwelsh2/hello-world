package com.nathan.mediaorganiser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SimpleController {
  @Value("${spring.application.name}")
  String appName;


  private final ResourceLoader resourceLoader;

  public SimpleController(ResourceLoader resourceLoader) {
    this.resourceLoader = resourceLoader;
  }

  Resource[] loadResources(String pattern) throws IOException {
    return ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources(pattern);
  }

  @GetMapping("/")
  public String homePage(Model model, @RequestParam String sortBy) throws IOException {
    model.addAttribute("appName", appName);
    Resource[] resources = loadResources("classpath*:/media/*");

   var files = new ArrayList<String>();
    for (final Resource res : resources) {
      if(sortBy.equals("lastModified")) {
        //res.lastModified()
      }
      String filename = res.getFilename();
      String extension = filename.substring(filename.lastIndexOf("."));
      files.add(res.getFilename());
    }
    model.addAttribute("files", files);
    model.addAttribute("sortBy", sortBy);
    return "home";

  }

  @GetMapping("/videos")
  public String video() {
    //only return videos

  }

  @GetMapping("/pictures")
  public String video() {
    //only return videos

  }

  @GetMapping("/audio")
  public String video() {
    //only return videos

  }
}