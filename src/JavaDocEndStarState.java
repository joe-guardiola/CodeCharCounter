
public class JavaDocEndStarState extends CommentParserState
{
	private static JavaDocEndStarState instance = null;
	public JavaDocEndStarState()
	{
		
	}
	
	public static JavaDocEndStarState getInstance()
	{
		if(instance == null)
		{
			instance = new JavaDocEndStarState();
		}
		
		return instance;
	}
	
	@Override
	public void star(CommentParser c)
	{
		c.setJavadocCounter(c.getJavadocCounter() + 1);
	}
	@Override
	public void slash(CommentParser c)
	{
		c.changeState(CodeState.getInstance());
		c.setJavadocCounter(c.getJavadocCounter() + 1);
	}
	@Override
	public void quote(CommentParser c)
	{
		c.changeState(JavaDocState.getInstance());
		c.setJavadocCounter(c.getJavadocCounter() + 1);
	}
	@Override
	public void backslash(CommentParser c)
	{
		c.changeState(JavaDocState.getInstance());
		c.setJavadocCounter(c.getJavadocCounter() + 1);
	}
	@Override
	public void endline(CommentParser c)
	{
		c.changeState(JavaDocState.getInstance());
	}
	@Override
	public void character(CommentParser c)
	{
		c.changeState(JavaDocState.getInstance());
		c.setJavadocCounter(c.getJavadocCounter() + 1);
	}
}
