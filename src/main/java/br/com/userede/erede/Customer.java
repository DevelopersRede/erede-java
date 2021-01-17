package br.com.userede.erede;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {

    public final static String MALE = "M";
    public final static String FEMALE = "F";

    @SerializedName("cpf")
    private String cpf;

    @SerializedName("documents")
    private List<Document> documents;

    @SerializedName("email")
    private String email;

    @SerializedName("name")
    private String name;

    @SerializedName("gender")
    private String gender;

    @SerializedName("phone")
    private Phone phone;

    private void prepareDocuments() {
        if (documents == null) {
            documents = new ArrayList<>();
        }
    }

    public Customer addDocument(String type, String number) {
        prepareDocuments();

        documents.add(new Document(type, number));

        return this;
    }

    public Iterator<Document> getDocumentsIterator() {
        prepareDocuments();

        return documents.iterator();
    }


    public String getCpf() {
        return cpf;
    }

    public Customer setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Customer setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Phone getPhone() {
        return phone;
    }

    public Customer setPhone(Phone phone) {
        this.phone = phone;
        return this;
    }

}
