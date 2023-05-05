package service;

import entity.AdminEntity;

public class AdminService {
    public AdminEntity adminEntity;
    //password verifica
    public boolean checkPassword(String password){
        return this.adminEntity.password.equals(password);
    }
    //aggiungere una nuova autorizzazione all'amministratore
    public void addAuthorization(String newAuthorization) {
        this.adminEntity.authorizations += "," + newAuthorization;
    }
    //verifica se l'amministratore ha un'autorizzazione specifica
    //divide la stringa authorizations in un array di stringhe, utilizzando la virgola come "separatore"
    public boolean hasAuthorization(String authorization) {
        String[] authArray = this.adminEntity.authorizations.split(",");
        for (String auth : authArray) {
            if (auth.equals(authorization)) {
                return true;
            }
        }
        return false;
    }
}
