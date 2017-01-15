
public class MultiLineState extends CommentParserState
{
	private static MultiLineState instance = null;
	public MultiLineState()
	{
		
	}
	
	public static MultiLineState getInstance()
	{
		if(instance == null)
		{
			instance = new MultiLineState();
		}
		
		return instance;
	}
	
	@Override
	public void star(CommentParser c)
	{
		c.changeState(MultiLineEndStar.getInstance());
		c.setCommentCounter(c.getCommentCounter() + 1);
	}
	@Override
	public void slash(CommentParser c)
	{
		c.setCommentCounter(c.getCommentCounter() + 1);
	}
	@Override
	public void quote(CommentParser c)
	{
		c.setCommentCounter(c.getCommentCounter() + 1);
	}
	@Override
	public void backslash(CommentParser c)
	{
		c.setCommentCounter(c.getCommentCounter() + 1);
	}
	@Override
	public void endline(CommentParser c)
	{
		
	}
	@Override
	public void character(CommentParser c)
	{
		c.setCommentCounter(c.getCommentCounter() + 1);
	}
}
