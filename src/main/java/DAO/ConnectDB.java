package DAO;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import models.User.UserAccount;
import models.User.UserInfo;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.pojo.PojoCodecProvider;

public class ConnectDB {
    public static String uri = "mongodb+srv://Vuong:Dinhvuong2005@cluster0.uexir.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

    public static ServerApi serverApi = ServerApi.builder()
            .version(ServerApiVersion.V1)
            .build();

    // Cấu hình Codec để hỗ trợ Pojo
    public static CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();

    public static MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(new ConnectionString(uri))
            .codecRegistry(CodecRegistries.fromRegistries(
                    MongoClientSettings.getDefaultCodecRegistry(),
                    CodecRegistries.fromProviders(pojoCodecProvider)
            ))
            .serverApi(serverApi)
            .build();

    public static MongoClient mongoClient = MongoClients.create(settings);

    // Truy cập cơ sở dữ liệu
    public static MongoDatabase db = mongoClient.getDatabase("HITDB");

    // Thay đổi kiểu của `collection` để hỗ trợ Pojo
    public static MongoCollection<UserAccount> collection = db.getCollection("UserAccount", UserAccount.class);
    public static MongoCollection<UserInfo> collectionInfo = db.getCollection("UserInfo", UserInfo.class);
}
