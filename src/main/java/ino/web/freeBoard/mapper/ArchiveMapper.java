package ino.web.freeBoard.mapper;

import java.util.List;

import ino.web.freeBoard.dto.ArchiveDto;
import ino.web.freeBoard.dto.Criteria;

public interface ArchiveMapper {
	
		public List<ArchiveDto> archiveGetList();
		
		public List<ArchiveDto> getArchiveList(Criteria criteria);
		
		public int getArchiveTotalCount(Criteria criteria);
		
		public List<ArchiveDto> searchArchiveListByType(Criteria criteria);
		
		
}
