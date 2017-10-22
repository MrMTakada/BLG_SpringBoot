package com.marineroad.springboot;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // (1)
public class ThymeleafController {

	/**
	 * Thymeleaf 基本編
	 *
	 * @param mav
	 *            ModelAndViewクラス テンプレートで利用するデータ類とビューに関する情報をまとめて管理するクラス
	 * @return
	 */
	@RequestMapping("/thdemo")
	public ModelAndView index(ModelAndView mav) {

		// 1.(1) 変数式
		// ・コントローラーからテンプレートに値を渡す
		// ・変数「msg」に値を設定
		mav.addObject("msg", "コントローラーからテンプレートに値を渡す");

		// 1.(2) 選択変数式
		// ・オブジェクトの中にあるプロパティ（フィールド）を取り出すためのもの
		// ・変数「object」に値を設定
		DataObject obj = new DataObject(123, "マリンロード", "https://www.marineroad.com/");
		mav.addObject("object", obj);

		// 2.(1) 繰り返し
		// ・配列やコレクションから繰り返し値を取り出すためのもの
		// ・変数「dataList」に値を設定
		ArrayList<DataObject> dataList = new ArrayList<DataObject>();
		dataList.add(new DataObject(1, "マリンロード", "https://www.marineroad.com/"));
		dataList.add(new DataObject(2, "ヤフー", "https://www.yahoo.co.jp/"));
		dataList.add(new DataObject(3, "グーグル", "https://www.google.co.jp/"));
		mav.addObject("dataList", dataList);

		// 使用するビューを設定
		mav.setViewName("thdemo"); // (3)

		return mav;
	}

}
