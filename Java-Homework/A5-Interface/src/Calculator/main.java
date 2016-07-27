package Calculator;
import java.awt.Font;
import java.io.IOException;
import javax.swing.*;
/***********************************************************
 程式介紹：
這個程式會做出一個小計算盤。可以計算小數點、整數加減乘除，位數過大的話會有overflow的保護。
同時也會過濾掉如「8.023443267E10」這種科學記號的表示方式。
功能介紹：
Interface: 製作GUI的畫面的class，處理按鍵的各個動作。
SimpleCalculator: 具有簡單的加減乘除功能。
FinalCalculator: 繼承自SimpleCalculator，做設值、取值等功能。
main: 叫出介面。助教給的code，不改動。
***********************************************************/

public class main {
	
	public static void main(String[] args) throws IOException {
		win frame = new win();//叫出介面
	}
	
}
