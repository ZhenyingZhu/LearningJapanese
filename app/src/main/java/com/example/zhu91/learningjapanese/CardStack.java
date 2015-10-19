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
    private int cheatIndex = 0;

    public static CardStack getInstance(boolean fresh) {
        if (fresh) {
            ourInstance = new CardStack();
        }
        return ourInstance;
    }

    private void addCard() {
        String[][] wordPair = {
                // Hiragana https://en.wikipedia.org/wiki/Hiragana
                {"あ","a"},
                {"い","i"},
                {"う","u"},
                {"え","e"},
                {"お","o"},
                {"か","ka"},
                {"き","ki"},
                {"く","ku"},
                {"け","ke"},
                {"こ","ko"},
                {"さ","sa"},
                {"し","shi"},
                {"す","su"},
                {"せ","se"},
                {"そ","so"},
                {"た","ta"},
                {"ち","chi"},
                {"つ","tsu"},
                {"て","te"},
                {"と","to"},
                {"な","na"},
                {"に","ni"},
                {"ぬ","nu"},
                {"ね","ne"},
                {"の","no"},
                {"は","ha"},
                {"ひ","hi"},
                {"ふ","fu"},
                {"へ","he"},
                {"ほ","ho"},
                {"ま","ma"},
                {"み","mi"},
                {"む","mu"},
                {"め","me"},
                {"も","mo"},
                {"や","ya"},
                {"ゆ","yu"},
                {"よ","yo"},
                {"ら","ra"},
                {"り","ri"},
                {"る","ru"},
                {"れ","re"},
                {"ろ","ro"},
                {"わ","wa"},
                {"を","o"},
                {"ん","n"},
                {"が","ga"},
                {"ぎ","gi"},
                {"ぐ","gu"},
                {"げ","ge"},
                {"ご","go"},
                {"ざ","za"},
                {"じ","ji"},
                {"ず","zu"},
                {"ぜ","ze"},
                {"ぞ","zo"},
                {"だ","da"},
                {"ぢ","ji"},
                {"づ","zu"},
                {"で","de"},
                {"ど","do"},
                {"ば","ba"},
                {"び","bi"},
                {"ぶ","bu"},
                {"べ","be"},
                {"ぼ","bo"},
                {"ぱ","pa"},
                {"ぴ","pi"},
                {"ぷ","pu"},
                {"ぺ","pe"},
                {"ぽ","po"},
                /* Digraphs with diacritics
                {"きゃ","kya"},
                {"きゅ","kyu"},
                {"きょ","kyo"},
                {"しゃ","sha"},
                {"しゅ","shu"},
                {"しょ","sho"},
                {"ちゃ","cha"},
                {"ちゅ","chu"},
                {"ちょ","cho"},
                {"にゃ","nya"},
                {"にゅ","nyu"},
                {"にょ","nyo"},
                {"ひゃ","hya"},
                {"ひゅ","hyu"},
                {"ひょ","hyo"},
                {"みゃ","mya"},
                {"みゅ","myu"},
                {"みょ","myo"},
                {"りゃ","rya"},
                {"りゅ","ryu"},
                {"りょ","ryo"},
                {"ぎゃ","gya"},
                {"ぎゅ","gyu"},
                {"ぎょ","gyo"},
                {"じゃ","ja"},
                {"じゅ","ju"},
                {"じょ","jo"},
                {"ぢゃ","ja"},
                {"ぢゅ","ju"},
                {"ぢょ","jo"},
                {"びゃ","bya"},
                {"びゅ","byu"},
                {"びょ","byo"},
                {"ぴゃ","pya"},
                {"ぴゅ","pyu"},
                {"ぴょ","pyo"},
                 */
                // Katakana https://en.wikipedia.org/wiki/Katakana
                {"ア","a"},
                {"イ","i"},
                {"ウ","u"},
                {"エ","e"},
                {"オ","o"},
                {"カ","ka"},
                {"キ","ki"},
                {"ク","ku"},
                {"ケ","ke"},
                {"コ","ko"},
                {"サ","sa"},
                {"シ","shi"},
                {"ス","su"},
                {"セ","se"},
                {"ソ","so"},
                {"タ","ta"},
                {"チ","chi"},
                {"ツ","tsu"},
                {"テ","te"},
                {"ト","to"},
                {"ナ","na"},
                {"ニ","ni"},
                {"ヌ","nu"},
                {"ネ","ne"},
                {"ノ","no"},
                {"ハ","ha"},
                {"ヒ","hi"},
                {"フ","fu"},
                {"ヘ","he"},
                {"ホ","ho"},
                {"マ","ma"},
                {"ミ","mi"},
                {"ム","mu"},
                {"メ","me"},
                {"モ","mo"},
                {"ヤ","ya"},
                {"ユ","yu"},
                {"ヨ","yo"},
                {"ラ","ra"},
                {"リ","ri"},
                {"ル","ru"},
                {"レ","re"},
                {"ロ","ro"},
                {"ワ","wa"},
                {"ヰ", "wi"},
                {"ヱ", "we"},
                {"ヲ","wo"},
                {"ン","n"},
                {"ガ","ga"},
                {"ギ","gi"},
                {"グ","gu"},
                {"ゲ","ge"},
                {"ゴ","go"},
                {"ザ","za"},
                {"ジ","ji"},
                {"ズ","zu"},
                {"ゼ","ze"},
                {"ゾ","zo"},
                {"ダ","da"},
                {"ヂ","ji"},
                {"ヅ","zu"},
                {"デ","de"},
                {"ド","do"},
                {"バ","ba"},
                {"ビ","bi"},
                {"ブ","bu"},
                {"ベ","be"},
                {"ボ","bo"},
                {"パ","pa"},
                {"ピ","pi"},
                {"プ","pu"},
                {"ペ","pe"},
                {"ポ","po"}
                /* Digraphs with diacritics
                ,{"キャ","kya"},
                {"キュ","kyu"},
                {"キョ","kyo"},
                {"シャ","sha"},
                {"シュ","shu"},
                {"ショ","sho"},
                {"チャ","cha"},
                {"チュ","chu"},
                {"チョ","cho"},
                {"ニャ","nya"},
                {"ニュ","nyu"},
                {"ニョ","nyo"},
                {"ヒャ","hya"},
                {"ヒュ","hyu"},
                {"ヒョ","hyo"},
                {"ミャ","mya"},
                {"ミュ","myu"},
                {"ミョ","myo"},
                {"リャ","rya"},
                {"リュ","ryu"},
                {"リョ","ryo"},
                {"ギャ","gya"},
                {"ギュ","gyu"},
                {"ギョ","gyo"},
                {"ジャ","ja"},
                {"ジュ","ju"},
                {"ジョ","jo"},
                {"ヂャ","ja"},
                {"ヂュ","ju"},
                {"ヂョ","jo"},
                {"ビャ","bya"},
                {"ビュ","byu"},
                {"ビョ","byo"},
                {"ピャ","pya"},
                {"ピュ","pyu"},
                {"ピョ","pyo"}
                 */
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

    public Card getRandomCard(boolean cheatMode) {
        int index;
        if (cheatMode) {
            index = cheatIndex++;
        } else {
            index = getRandomIndex();
        }
        if (index == -1 || index >= array.size())
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
