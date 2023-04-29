package start.services;

import start.entities.Admin;

public class AdminService {
    public Admin admin;
    //password verifica
    public boolean checkPassword(String password){
        return this.admin.getPassword().equals(password);
    }
    //aggiungere una nuova autorizzazione all'amministratore
    public void addAuthorization(String newAuthorization) {
        admin.setAuthorizations(admin.getAuthorizations() + ", " + newAuthorization);
    }
    //verifica se l'amministratore ha un'autorizzazione specifica
    //divide la stringa authorizations in un array di stringhe, utilizzando la virgola come "separatore"
    public boolean hasAuthorization(String authorization) {
        String[] authArray = this.admin.getAuthorizations().split(",");
        for (String auth : authArray) {
            if (auth.equals(authorization)) {
                return true;
            }
        }
        return false;
    }


}

