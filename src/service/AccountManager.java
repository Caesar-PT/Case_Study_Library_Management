package service;

import module.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    List<Account> accountList = new ArrayList<>();

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public void editPassWordAccount(String user, String password) {
        for (Account a : accountList) {
            if (a.getUser().equalsIgnoreCase(user)) {
                a.setPassword(password);
                System.out.println("Đổi pass thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy user");
    }

    public void delAcccount(String user){
        for (Account a:accountList) {
            if (a.getUser().equalsIgnoreCase(user)){
                accountList.remove(a);
                System.out.println("Xóa thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy Account");
    }
}
