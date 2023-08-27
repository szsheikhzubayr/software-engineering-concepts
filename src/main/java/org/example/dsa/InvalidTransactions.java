package org.example.dsa;

import java.util.*;

public class InvalidTransactions {
    static class TxnDetails{
        Integer time;
        Integer amount;
        String city;
        Boolean addStatus;
        public TxnDetails(Integer time,Integer amount, String city){
            this.time = time;
            this.city = city;
            this.amount = amount;
        }
        public TxnDetails(Integer time,Integer amount, String city,Boolean addStatus){
            this.time = time;
            this.city = city;
            this.amount = amount;
            this.addStatus = addStatus;
        }
        public int getTime(){
            return time;
        }
        public int getAmount(){
            return amount;
        }
        public String getCity(){
            return city;
        }
        public Boolean getAddStatus(){
            return addStatus;
        }
    }
    public static  List<String> invalidTransactions(String[] transactions) {

        List<String> invalidTransactions = new ArrayList<>();
        //name,time(s),amount,city
        //"alice,20,800,mtv",
        //"bob,50,1200,mtv"
        //amt>1000 or (time_diff<60 + same name + diff city)
        Map<String, List<TxnDetails>> txnDetailsMap = new HashMap<>();

        for(int i = 0; i < transactions.length; i++){
            String transaction = transactions[i]; //"alice,20,800,mtv"
            String[] txn_details = transaction.split(",");
            String name = txn_details[0];
            Integer time = Integer.parseInt(txn_details[1]);
            Integer amount = Integer.parseInt(txn_details[2]);
            String city = txn_details[3];

            //check for amt>1000, if true no need to check other conditions and move to next transaction
            if(amount > 1000){
                invalidTransactions.add(transaction);
                continue;
            }

            if(txnDetailsMap.containsKey(name)){
                List<TxnDetails> txnDetailsList = txnDetailsMap.get(name);
                Integer matchedTxnTime = txnDetailsList.get(0).getTime();
                Integer matchedTxnAmount = txnDetailsList.get(0).getAmount();
                String matchedTxnCity = txnDetailsList.get(0).getCity();
                Boolean addStatus = txnDetailsList.get(0).getAddStatus();
                //if the transaction has same name, time diff<60 & diff city
                if(!matchedTxnCity.equalsIgnoreCase(city) && Math.abs(matchedTxnTime - time) < 60){

                    String matchedTxn = name.concat(",").concat(String.valueOf(matchedTxnTime)).concat(",").concat(String.valueOf(matchedTxnAmount)).concat(",").concat(matchedTxnCity);
                    if(amount != matchedTxnAmount){
                        System.out.println("matchedTxn: " + matchedTxn);
                        invalidTransactions.add(matchedTxn);
                        List<TxnDetails> updatedTxnDetailsList = new ArrayList<>();
                        updatedTxnDetailsList.add(new TxnDetails(matchedTxnTime,matchedTxnAmount,matchedTxnCity,true));//add the time amount & city alongwith add status
                        //update add status in map
                        txnDetailsMap.replace(name,updatedTxnDetailsList);
                    }
                    System.out.println("transaction: " + transaction);
                    invalidTransactions.add(transaction);

                }
            }else{
                //add the transaction to the map of transactions for comparing against other transactions in the list
                List<TxnDetails> txnDetailsList = new ArrayList<>();
                txnDetailsList.add(new TxnDetails(time,amount,city,false));//add the time & city
                txnDetailsMap.put(name,txnDetailsList); //add the name as key & amount & city as values
                System.out.println(name + "," + time + "," + amount + "," + city + " added to map");
            }
        }
        return invalidTransactions;
    }

    public static void main(String[] args) {
      String[] transactions = {"alice,20,800,mtv","alice,50,100,mtv","alice,51,100,frankfurt"};
      System.out.println(invalidTransactions(transactions));
    }
}
