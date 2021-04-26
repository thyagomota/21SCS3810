/*
 * CS3810 - Principles of Database Systems - Spring 2021
 * Instructor: Thyago Mota
 * Description: DB 04 - ArticleSource
 * Student(s) Name(s):
 */

import org.bson.Document;

public class ArticleSource {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "source={" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    // TODO: return a Document object representing the article source
    public Document toDocument() {
        return null;
    }
}
