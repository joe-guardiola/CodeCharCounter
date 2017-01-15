
public class MultiLineEndStar extends CommentParserState
{
	private static MultiLineEndStar instance = null;
	public MultiLineEndStar()
	{
		
	}
	
	public static MultiLineEndStar getInstance()
	{
		if(instance == null)
		{
			instance = new MultiLineEndStar();
		}
		
		return instance;
	}
	
	@Override
	public void star(CommentParser c)
	{
		c.setCommentCounter(c.getCommentCounter() + 1);
	}
	@Override
	public void slash(CommentParser c)
	{
		c.changeState(CodeState.getInstance());
		c.setCommentCounter(c.getCommentCounter() + 1);
	}
	@Override
	public void quote(CommentParser c)
	{
		c.changeState(MultiLineState.getInstance());
		c.setCommentCounter(c.getCommentCounter() + 1);
	}
	@Override
	public void backslash(CommentParser c)
	{
		c.changeState(MultiLineState.getInstance());
		c.setCommentCounter(c.getCommentCounter() + 1);
	}
	@Override
	public void endline(CommentParser c)
	{
		c.changeState(MultiLineState.getInstance());
	}
	@Override
	public void character(CommentParser c)
	{
		c.changeState(MultiLineState.getInstance());
		c.setCommentCounter(c.getCommentCounter() + 1);
	}
}
