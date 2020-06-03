# list
```java
구현부인 BoardServiceImpl을 작성해줍니다.

여기서 dao.list();는 dao에있는 list()함수를 호출해서 반환하겠다는 뜻입니다.

 

	// 게시물 목록 조회
	@Override
	public List<BoardVO> list() throws Exception {

		return dao.list();
	}
```

# Write
```java
import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dao.BoardDAO;
import kr.co.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	// 게시글 작성
	@Override
	public void write(BoardVO boardVO) throws Exception {
		dao.write(boardVO);
	}

}
```

# 읽기
```java
BoardServiceImpl

// 게시물 목록 조회
@Override
public BoardVO read(int bno) throws Exception {

	return dao.read(bno);
}
```
