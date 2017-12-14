package com.example.oscar.wallet.DB;

import java.util.UUID;

/**
 * Created by oscar on 2/12/2017.
 */

public class WalletContract {


    interface  AccountColumns{
        String ID="id";
        String TITLE="title";
        String AMOUNT="amount";
        String ACCOUNT_TYPE="account_type";
    }
    interface OperationColumns{
        String  ID = "id";
        String  AMOUNT="amount";
        String  DATE="date";
        String  OPERATION_TYPE="operation_type";
        String  ID_ACCOUNT="id_account";
        String  ID_CATEGORY="id_category";
        String  DESCRIPCION="description";
    }
    interface  CategoryColumns{
        String ID="id";
        String DESCRIPTION="description";
    }
    public static class Accounts implements AccountColumns {
        public static String generateIdAccount() {
            return "ACC-" + UUID.randomUUID().toString();
        }
    }
    public static class Categories implements CategoryColumns{
        public static String generateIdCategory() {
            return "CAT-" + UUID.randomUUID().toString();
        }
    }
    public static class Operations implements OperationColumns{
        public static String generateIdOperation() {
            return "OPE-" + UUID.randomUUID().toString();
        }
    }
}
