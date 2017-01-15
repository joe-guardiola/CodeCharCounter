
public class BackslashState extends CommentParserState
{
	private static BackslashState instance = null;
	public BackslashState()
	{
		
	}
	
	public static BackslashState getInstance()
	{
		if(instance == null)
		{
			instance = new BackslashState();
		}
		
		return instance;
	}
	
	@Override
	public void star(CommentParser c)
	{
		c.changeState(QuoteState.getInstance());
		c.setCodeCounter(c.getCodeCounter() + 1);
	}
	@Override
	public void slash(CommentParser c)
	{
		c.changeState(QuoteState.getInstance());
		c.setCodeCounter(c.getCodeCounter() + 1);
	}
	@Override
	public void quote(CommentParser c)
	{
		c.changeState(QuoteState.getInstance());
		c.setCodeCounter(c.getCodeCounter() + 1);
	}
	@Override
	public void backslash(CommentParser c)
	{
		c.changeState(QuoteState.getInstance());
		c.setCodeCounter(c.getCodeCounter() + 1);
	}
	@Override
	public void endline(CommentParser c)
	{
		c.changeState(QuoteState.getInstance());
	}
	@Override
	public void character(CommentParser c)
	{
		c.changeState(QuoteState.getInstance());
		c.setCodeCounter(c.getCodeCounter() + 1);
	}
}
