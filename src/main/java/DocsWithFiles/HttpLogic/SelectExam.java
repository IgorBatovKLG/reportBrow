package DocsWithFiles.HttpLogic;

import Signature.Models.SignatureModelHttp;
import Signature.Models.SignatureModelHttpList;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class SelectExam {
    public List<SignatureModelHttp> getSignatureExam(String date, ArrayList<String> strings){
        Gson builder = new Gson();
        List<SignatureModelHttp> listSearchEntity = new ArrayList<>();
        try {
            String json = "{\"Columns\":[\"ExamBuroName\",\"FirstName\",\"SecondName\",\"LastName\"],\"Conditions\":[{\"FieldName\":\"DecisionDate\",\"Type\":9,\"IsNegative\":false,\"Disabled\":false,\"Value\":null,\"Values\":[\""+date+"T00:00:00\",\""+date+"T00:00:00\"]}],\"HidePeopleDoubles\":false,\"Page\":1,\"PageSize\":10000,\"SortField\":null,\"IsSortDesc\":false,\"CacheId\":\"1ec2fa7d-1c98-4e8f-b226-97eaeb67e4c5\",\"InvalidateCache\":true}";

            HttpClient client = HttpClient.newHttpClient();
            String Cookie = strings.get(0) +"="+ strings.get(2) +"; "+ strings.get(1) +"="+ strings.get(3);
            HttpRequest request  = HttpRequest.newBuilder().uri(new URI("http://dbs/eva/Search/SearchData"))
                    .setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:99.0) Gecko/20100101 Firefox/99.0")
                    .header("Content-Type","application/json; charset=utf-8")
                    .header("Cookie", Cookie)
                    //.header("Cookie","menuCollapsed=True; .AspNetCore.Antiforgery.KmBJtTtqA9M=CfDJ8BoCWCcBYzxPliYJbn68VWQIo5wckFJxyfBVt2f-VIlJy-EePWqCESUQw3eBthzfUp7lXMhqbzqE7BoK_cZZdPso3uRGCg4TRgJpgTAQtd6_F57nRZT-zJGVKjfDetuF74Head87ayh6U2YerMP_uoc; eaviias_auth=CfDJ8BoCWCcBYzxPliYJbn68VWSgbisswCfePLG7iDp7l7eQrPFqulkrCYBsQAZB_V0ALKQxegR98Pk7IKaYfc--hzYwyPbQhS1HZL7FGwn2EddqMI0PDK_E5jNg-bZ0wh4g8s6JzFxbt42vFqirLdVcZtq6g8hfNEiVuPNUzTu0mo30mGZxrBu9PBiqiAPpInW6SIJk-HTbMkmewumRqAj72bxw-gg3R4w5wI1pnqcwAI4MKV-r5viRcNM22C73B-Gaq95IGWk6OJtPA2zVdJ1p7SXsDsk64Obixk7Wsdk6u6UwXDv3Y8dAKwABPBNqcBIAtqQnq1029io_haVTCFQ9yP8CMXdQFc7ewQN66taJIYm7f-bFeQqRDOaWEE9G7kIeRj8ViSQgGH4H0pJvVOy-8hA")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<?> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            SignatureModelHttpList signatureModelHttpList = builder.fromJson(response.body().toString(), SignatureModelHttpList.class);
            listSearchEntity = signatureModelHttpList.getList();
            System.out.println(signatureModelHttpList.getList().size());
            System.out.println(signatureModelHttpList.getTotal());


        } catch (URISyntaxException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return listSearchEntity;
    }
}
