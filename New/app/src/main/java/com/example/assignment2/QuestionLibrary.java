package com.example.assignment2;

public class QuestionLibrary {



    public String mQuestions [] = {
            "以下那部不是莎士比亞四大悲劇之一？",
            "石壁水塘位於哪裏？",
            "以下那一項不是霧的特徵？",
            "DNA的中文醫學譯名是什麼？",
            "地球最深層的內地核是什麼狀態？"
    };

    private String mChoices [][] ={
            {"李爾王","奧賽羅","哈姆萊特","羅密歐與茱麗葉"},
            {"西貢","港島","大嶼山","荃灣"},
            {"水蒸氣在低空凝結","令能見度減低","在晴朗的清晨出現","在潮濕較冷的早晚出現"},
            {"脱氧核醣核酸","無核醣核酸","脱氧酸","脱氧核酸"},
            {"真空","固體","液體","氣體"}
    };

    private String mCorrectAnswer [] = {
            "羅密歐與茱麗葉",
            "大嶼山",
            "在晴朗的清晨出現",
            "脱氧核醣核酸",
            "固體"
    };

    public String getQuestion (int a){

        String question = mQuestions[a];
        return question;
    }

    public String getChoice1 (int a){
        String choice0 = mChoices[a][0];
        return choice0;
    }
    public String getChoice2 (int a){
        String choice1 = mChoices[a][1];
        return choice1;
    }
    public String getChoice3 (int a){
        String choice2 = mChoices[a][2];
        return choice2;
    }
    public String getChoice4 (int a){
        String choice3 = mChoices[a][3];
        return choice3;
    }
    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswer[a];
        return answer;
    }

}

