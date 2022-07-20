package Signature.DTO;


import Signature.Models.SignatureModel;
import Signature.Models.SignatureModelHttp;

import java.util.ArrayList;
import java.util.List;

public class SignatureDTO {

    public static ArrayList<SignatureModel> fromDTO(List<SignatureModelHttp> list){
        ArrayList<SignatureModel> models = new ArrayList<>();
        for (SignatureModelHttp s:list){

            models.add(new SignatureModel("http://dbs/eva/Exam/GetItem/" + s.getId(),
                    s.getExamBuroName(),
                    s.getLastName() + " " + s.getFirstName() + " " + s.getSecondName(),
                    new ArrayList<String>()));

        }

        return models;
    }
}