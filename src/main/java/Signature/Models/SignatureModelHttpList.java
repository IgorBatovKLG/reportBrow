package Signature.Models;

import java.util.List;

public class SignatureModelHttpList {
    private List<SignatureModelHttp> List;
    private int Total;
    private String CacheId;

    public SignatureModelHttpList(java.util.List<SignatureModelHttp> list, int total, String cacheId) {
        List = list;
        Total = total;
        CacheId = cacheId;
    }

    public java.util.List<SignatureModelHttp> getList() {
        return List;
    }

    public void setList(java.util.List<SignatureModelHttp> list) {
        List = list;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public String getCacheId() {
        return CacheId;
    }

    public void setCacheId(String cacheId) {
        CacheId = cacheId;
    }
}
