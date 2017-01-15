
public class SingleLineCommentState extends CommentParserState
{
	private static SingleLineCommentState instance = null;
	public SingleLineCommentState()
	{
		
	}
	
	public static SingleLineCommentState getInstance()
	{
		if(instance == null)
		{
			instance = new SingleLineCommentState();
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
		c.changeState(CodeState.getInstance());
	}
	@Override
	public void character(CommentParser c)
	{
		c.setCommentCounter(c.getCommentCounter() + 1);
	}
}
