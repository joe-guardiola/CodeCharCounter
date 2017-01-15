
public class StarState extends CommentParserState
{
	private static StarState instance = null;
	public StarState()
	{
		
	}
	
	public static StarState getInstance()
	{
		if(instance == null)
		{
			instance = new StarState();
		}
		
		return instance;
	}
	
	@Override
	public void star(CommentParser c)
	{
		c.changeState(JavaDocState.getInstance());
		c.setJavadocCounter(c.getJavadocCounter() + 3);
	}
	@Override
	public void slash(CommentParser c)
	{
		c.changeState(MultiLineState.getInstance());
		c.setCommentCounter(c.getCommentCounter() +  3);
	}
	@Override
	public void quote(CommentParser c)
	{
		c.changeState(MultiLineState.getInstance());
		c.setCommentCounter(c.getCommentCounter() +  3);
	}
	@Override
	public void backslash(CommentParser c)
	{
		c.changeState(MultiLineState.getInstance());
		c.setCommentCounter(c.getCommentCounter() +  3);
	}
	@Override
	public void endline(CommentParser c)
	{
		c.changeState(MultiLineState.getInstance());
		c.setCommentCounter(c.getCommentCounter() +  2);
	}
	@Override
	public void character(CommentParser c)
	{
		c.changeState(MultiLineState.getInstance());
		c.setCommentCounter(c.getCommentCounter() +  3);
	}
}
