package jp.ac.emoji.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginForm {

    @NotBlank(message = "メールアドレスを入力してください")
    @Email(message = "メールアドレスの形式が正しくありません")
    private String userMail;

    @NotBlank(message = "パスワードを入力してください")
    @Size(min = 4, max = 20, message = "パスワードは4〜20文字で入力してください")
    @Pattern(regexp = "^[a-zA-Z0-9]+$",message = "パスワードの形式が正しくありません")
    private String password;



    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
