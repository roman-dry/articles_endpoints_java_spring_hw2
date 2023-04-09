package com.example.articles;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Articles {
    Map<Integer, String> articles = new HashMap<Integer, String>();

    {
        articles.put(1, "Стаття 1. Україна є суверенна і незалежна, демократична, " +
                "соціальна, правова держава.");
        articles.put(2, "Стаття 2. Суверенітет України поширюється на всю її територію.\n" +
                "\n" +
                "Україна є унітарною державою.\n" +
                "\n" +
                "Територія України в межах існуючого кордону є цілісною і недоторканною.");
        articles.put(3, "Стаття 3. Людина, її життя і здоров'я, честь і гідність, недоторканність і " +
                "безпека визнаються в Україні найвищою соціальною цінністю.\n" +
                "\n" +
                "Права і свободи людини та їх гарантії визначають зміст і спрямованість діяльності держави." +
                " Держава відповідає перед людиною за свою діяльність. Утвердження і забезпечення прав і " +
                "свобод людини є головним обов'язком держави.");
    }

    @GetMapping("/all")
    public String allArticles() {
        return articles.values().toString();

    }

    @GetMapping("/article")
    public String allArticles(HttpServletRequest request) {

        Integer key = Integer.valueOf(request.getParameter("key"));
        if(key > 0 && key < 4) {
            return articles.get(key);
        }
        return "";
    }

    @GetMapping("/articles")
    public Collection<String> getArticles() {
        return articles.values();
    }

    @PostMapping("/articles")
    public ResponseIdHolder postArticle(@RequestBody @Validated Article article) {
        var response = new ResponseIdHolder();
        response.setKey(articles.size());
        articles.put(response.getKey(), article.getArticle());
        return response;

    }

    @PutMapping("/articles")
    public String putArticleByKey(@RequestBody ResponseIdHolder key, Article article) {
        articles.put(key.getKey(), article.getArticle());
        return articles.toString();
    }

    @DeleteMapping("/articles{key}")
    public void deleteArticleByKey(@PathVariable ResponseIdHolder key) {
        articles.remove(key.getKey());
    }



}
