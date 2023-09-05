package ino.web.freeBoard.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ino.web.freeBoard.dto.Criteria;
import ino.web.freeBoard.dto.FreeBoardDto;

@Service
public class FreeBoardService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate; 
	
	
	public List<FreeBoardDto> getFreeBoardList(Criteria criteria) {
        return sqlSessionTemplate.selectList("freeBoardGetList", criteria);
	}
	
	public int getTotal(Criteria criteria) {
		return sqlSessionTemplate.selectOne("getTotalCount", criteria);
	}
	
	public void freeBoardInsertPro(FreeBoardDto dto){
		sqlSessionTemplate.insert("freeBoardInsertPro",dto);
	}
	
	public FreeBoardDto getDetailByNum(int num){
		return sqlSessionTemplate.selectOne("freeBoardDetailByNum", num);
	}
	public List<FreeBoardDto> searchByName(String name) {
	    return sqlSessionTemplate.selectList("freeBoardSearchByName", name);
	}

	public List<FreeBoardDto> serchByTitle(String title){
		return sqlSessionTemplate.selectOne("freeBoardSerchByTitle",title);
	}
	
	public void freeBoardUpdate(FreeBoardDto update){
		sqlSessionTemplate.update("freeBoardUpdate", update);
		
	}
	
	public void freeBoardDelete(int num){
	    sqlSessionTemplate.delete("deleteFreeBoard", num);
	    sqlSessionTemplate.update("decreaseNumAfterDelete", num);
	}
	public List<FreeBoardDto> searchFreeBoardListByType(Criteria criteria) {
        return sqlSessionTemplate.selectList("searchFreeBoardListByType", criteria);
    }

}
	
