package com.aischool.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.aischool.entity.Board;

@Mapper
public interface BoardMapper {
	
	@Select("SELECT * FROM BOARD")
	public ArrayList<Board> list();

	@Select("SELECT * FROM BOARD WHERE IDX = #{idx}")
	public Board content(int idx);

	@Insert("INSERT INTO BOARD(TITLE, CONTENT, WRITER, IMGPATH) VALUES(#{title}, #{content}, #{writer}, #{imgpath})")
	public void insert(Board vo);

}
