package DAO;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.IndexOptions;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Indexes.ascending;

public class ConnectDB {
    public static String uri = "mongodb+srv://Vuong:Dinhvuong2005@cluster0.uexir.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    public static ServerApi serverApi = ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build();
    public static  MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString(uri))
            .serverApi(serverApi)
            .build();
    public static MongoClient mongoClient = MongoClients.create(settings);
    public static MongoDatabase db = mongoClient.getDatabase("HITDB");
    public static MongoCollection collection = db.getCollection("test");
}
