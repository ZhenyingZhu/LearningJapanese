package com.example.zhu91.learningjapanese;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Zhu91 on 10/18/2015.
 */
public class CardStack {
    private static CardStack ourInstance = new CardStack();
    private ArrayList<Card> array;
    private Card prevCard;

    public static CardStack getInstance(boolean fresh) {
        if (fresh) {
            ourInstance = new CardStack();
        }
        return ourInstance;
    }

    private void addCard() {
        String[][] wordPair = {
                {"あ","a"},
                {"い","i"},
                {"う","u"},
                {"え","e"},
                {"お","o"},
                {"ア","a"},
                {"イ","i"},
                {"ウ","u"},
                {"エ","e"},
                {"オ","o"},
                {"か","ka"},
                {"き","ki"},
                {"く","ku"},
                {"け","ke"},
                {"こ","ko"},
                {"カ","ka"},
                {"キ","ki"},
                {"ク","ku"},
                {"ケ","ke"},
                {"コ","ko"},
                {"さ","sa"},
                {"し","si"},
                {"す","su"},
                {"せ","se"},
                {"そ","so"},
                {"サ","sa"},
                {"シ","si"},
                {"ス","su"},
                {"セ","se"},
                {"ソ","so"},
                {"た","ta"},
                {"ち","chi"},
                {"つ","tsu"},
                {"て","te"},
                {"と","to"},
                {"タ","ta"},
                {"チ","chi"},
                {"ツ","tsu"},
                {"テ","te"},
                {"ト","to"},
                {"な","na"},
                {"に","ni"},
                {"ぬ","nu"},
                {"ね","ne"},
                {"の","no"},
                {"ナ","na"},
                {"ニ","ni"},
                {"ヌ","nu"},
                {"ネ","ne"},
                {"ノ","no"},
                {"は","ha"},
                {"ひ","hi"},
                {"ふ","fu"},
                {"へ","he"},
                {"ほ","ho"},
                {"ハ","ha"},
                {"ヒ","hi"},
                {"フ","fu"},
                {"ヘ","he"},
                {"ホ","ho"},
                {"ま","ma"},
                {"み","mi"},
                {"む","mu"},
                {"め","me"},
                {"も","mo"},
                {"マ","ma"},
                {"ミ","mi"},
                {"ム","mu"},
                {"メ","me"},
                {"モ","mo"},
                {"や","ya"},
                {"ゆ","yu"},
                {"よ","yo"},
                {"ヤ","ya"},
                {"ユ","yu"},
                {"ヨ","yo"},
                {"ら","ra"},
                {"り","ri"},
                {"る","ru"},
                {"れ","re"},
                {"ろ","ro"},
                {"ラ","ra"},
                {"リ","ri"},
                {"ル","ru"},
                {"レ","re"},
                {"ロ","ro"},
                {"わ","wa"},
                {"を","wo"},
                {"ん","n"},
                {"ワ","wa"},
                {"ヲ","wo"},
                {"ン","n"}
        };
        array = new ArrayList<Card>();
        for (int i = 0; i < wordPair.length; i++) {
            array.add(new Card(wordPair[i][0], wordPair[i][1]));
        }
    }

    private CardStack() {
        addCard();
    }

    public String compareResult(String input) {
        String expectInput = prevCard.getContent();
        if (input.equals(expectInput)) {
            prevCard.setCorrect();
            return "Right";
        } else {
            return "Wrong: " + expectInput;
        }
    }

    public Card getRandomCard() {
        int index = getRandomIndex();
        if (index == -1)
            return null;
        Card card = array.get(index);
        prevCard = card;
        return card;
    }

    private int getRandomIndex() {
        ArrayList<Integer> available = new ArrayList<Integer>();
        for (int i = 0; i < array.size(); i++) {
            if (!array.get(i).getCorrect())
                available.add(i);
        }

        if (available.size() == 0)
            return -1;

        return available.get(new Random().nextInt(available.size()));
    }
}
