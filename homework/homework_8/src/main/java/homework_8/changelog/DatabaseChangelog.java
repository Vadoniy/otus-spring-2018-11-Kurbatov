package homework_8.changelog;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

@ChangeLog
public class DatabaseChangelog {

    @ChangeSet(order = "001", id = "insertMetro2033", author = "Vadoniy")
    public void insertMetro2033(DB db){
        DBCollection myCollection = db.getCollection("books");
        BasicDBObject doc = new BasicDBObject().append("title", "Metro 2033");
        doc.append("author", "Dmitry Glukhovsky");
        doc.append("genre", "Non-fiction");
        myCollection.insert(doc);
    }

    @ChangeSet(order = "002", id = "insertMetro2034", author = "Vadoniy")
    public void insertMetro2034(DB db){
        DBCollection myCollection = db.getCollection("books");
        BasicDBObject doc = new BasicDBObject().append("title", "Metro 2034");
        doc.append("author", "Dmitry Glukhovsky");
        doc.append("genre", "Non-fiction");
        myCollection.insert(doc);
    }

    @ChangeSet(order = "003", id = "insertMetro2035", author = "Vadoniy")
    public void insertMetro2035(DB db){
        DBCollection myCollection = db.getCollection("books");
        BasicDBObject doc = new BasicDBObject().append("title", "Metro 2035");
        doc.append("author", "Dmitry Glukhovsky");
        doc.append("genre", "Non-fiction");
        myCollection.insert(doc);
    }

    @ChangeSet(order = "004", id = "insertDoomedCity", author = "Vadoniy")
    public void insertDoomedCity(DB db){
        DBCollection myCollection = db.getCollection("books");
        BasicDBObject doc = new BasicDBObject().append("title", "Doomed City");
        doc.append("author", "Strugatsky brothers");
        doc.append("genre", "Non-fiction");
        myCollection.insert(doc);
    }

    @ChangeSet(order = "005", id = "insertCrimeAndPunishment", author = "Vadoniy")
    public void insertCrimeAndPunishment(DB db){
        DBCollection myCollection = db.getCollection("books");
        BasicDBObject doc = new BasicDBObject().append("title", "Crime and Punishment");
        doc.append("author", "Dostoevsky F.M.");
        doc.append("genre", "Classic");
        myCollection.insert(doc);
    }

    @ChangeSet(order = "006", id = "insertReviewMetro2035", author = "Vadoniy")
    public void insertReviewMetro2035(DB db){
        DBCollection myCollection = db.getCollection("reviews");
        BasicDBObject doc = new BasicDBObject().append("book", "Metro 2035");
        doc.append("review", "People are never change");
        doc.append("reviewOwner", "Vadoniy");
        myCollection.insert(doc);
    }

    @ChangeSet(order = "007", id = "insertReviewCrimeAndPunishment", author = "Vadoniy")
    public void insertReviewCrimeAndPunishment(DB db){
        DBCollection myCollection = db.getCollection("reviews");
        BasicDBObject doc = new BasicDBObject().append("book", "Crime and Punishment");
        doc.append("review", "Must read");
        doc.append("reviewOwner", "Sergey");
        myCollection.insert(doc);
    }
}
