package ino.web.freeBoard.mapper;

import java.util.List;



import ino.web.freeBoard.dto.Criteria;
import ino.web.freeBoard.dto.FreeBoardDto;

public interface FreeBoardMapper {
	
		public List<FreeBoardDto> freeBoardGetList();
		
		public List<FreeBoardDto> getFreeBoardList(Criteria criteria);
		
		public int getTotalCount(Criteria criteria);
		
		public List<FreeBoardDto> searchFreeBoardListByType(Criteria criteria);
		
		
}
