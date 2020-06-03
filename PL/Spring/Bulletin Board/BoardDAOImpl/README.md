# write
```java
package kr.co.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;
	
	// 게시글 작성
	@Override
	public void write(BoardVO boardVO) throws Exception {
		sqlSession.insert("boardMapper.insert", boardVO);
		
	}

}
```

# 조회
```java
구현부인 BoardDAOImpl로 들어가셔서 인터페이스 BoardDAO에 정의된 멤버들을 클래스에서 대신 구현 해야합니다.

return sqlSession.selectList("boardMapper.list");

이것은 boardMapper.xml에서 mapper의 namespace가 boardMapper이고 그중에 id가 list인것을 가져와서 반환해라

라고 생각하시면 됩니다.

 

	// 게시물 목록 조회
	@Override
	public List<BoardVO> list() throws Exception {
	
		return sqlSession.selectList("boardMapper.list");

	}
```
