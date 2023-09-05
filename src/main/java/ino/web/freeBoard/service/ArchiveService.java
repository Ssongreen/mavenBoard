package ino.web.freeBoard.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ino.web.freeBoard.dto.ArchiveDto;
import ino.web.freeBoard.dto.Criteria;

@Service
public class ArchiveService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List<ArchiveDto> getArchiveList(Criteria criteria) {
		return sqlSessionTemplate.selectList("archiveGetList", criteria);
	}

	public int getArchiveTotal(Criteria criteria) {
		return sqlSessionTemplate.selectOne("getArchiveTotalCount", criteria);
	}

	public void archiveInsertPro(ArchiveDto dto) {
		sqlSessionTemplate.insert("archiveInsertPro", dto);
	}

	public ArchiveDto getArchiveDetailByNum(int num) {
		return sqlSessionTemplate.selectOne("archiveDetailByNum", num);
	}

	public List<ArchiveDto> archivesearchByName(String name) {
		return sqlSessionTemplate.selectList("archiveSearchByName", name);
	}

	public List<ArchiveDto> archiveSearchByTitle(String title) {
		return sqlSessionTemplate.selectList("archiveSerchByTitle", title);
	}

	public void archiveUpdate(ArchiveDto update) {
		sqlSessionTemplate.update("archiveUpdate", update);

	}

	public void archiveDelete(ArchiveDto delete) {
		sqlSessionTemplate.delete("archiveDelete", delete);
		sqlSessionTemplate.update("archiveNumAfterDelete", delete.getNum());

	}
	public void archiveFileDelete(ArchiveDto delete) {
		sqlSessionTemplate.update("archiveFileDelete", delete);
		
	}
	
	
	public List<ArchiveDto> searchArchiveListByType(Criteria criteria) {
		return sqlSessionTemplate.selectList("searchArchiveListByType", criteria);

	}
	
}
