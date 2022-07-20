package Signature.Models;

import java.util.ArrayList;

public class SignatureModel {
    private String link;
    private String buro;
    private String name;
    private ArrayList<String> signatureName;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getBuro() {
        return buro;
    }

    public void setBuro(String buro) {
        this.buro = buro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getSignatureName() {
        return signatureName;
    }

    public void setSignatureName(ArrayList<String> signatureName) {
        this.signatureName = signatureName;
    }

    public SignatureModel(String link, String buro, String name, ArrayList<String> signatureName) {
        this.link = link;
        this.buro = buro;
        this.name = name;
        this.signatureName = signatureName;
    }
}
