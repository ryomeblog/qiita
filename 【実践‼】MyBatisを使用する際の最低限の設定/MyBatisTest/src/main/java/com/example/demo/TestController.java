package com.example.demo;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    // ルートとなる設定ファイルを読み込む
	InputStream in = TestController.class.getResourceAsStream("/mybatis-config.xml");

	// 設定ファイルを元に SqlSessionFactory を作成する
	SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

	// SqlSessionFactory から SqlSession を生成する
	SqlSession session = factory.openSession();

    @GetMapping("/")
    public String index(Model model) {

    	// SqlSession を使って SQL を実行する
    	List<Entity> result = session.selectList("sample.mybatis.selectTest");

        model.addAttribute("Test", result);
        return "index";
    }
}