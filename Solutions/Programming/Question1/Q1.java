package Question1;

public class Q1 {
	public static void main(String[] args)
    {
		String sentence= "hello, my name is chia huang";
		String result ="";
		String[] wordList = sentence.split(" ");
		for(int i = 0;i < wordList.length; i++) {
			if(i % 2 == 0) {
				wordList[i] = wordList[i].substring(0,1).toUpperCase() + wordList[i].substring(1);
				result += wordList[i] + " ";
				
			}
			else
			{
				result += wordList[i] + " ";
			}
		}
		System.out.println(result);
	}
}


//	String capitalizeFirstLetter(String sentence) {
//		String result ="";
//		String[] wordList = sentence.split(" ");
//		for(int i = 0;i < wordList.length; i++) {
//			if(i % 2 == 0) {
//				wordList[i] = wordList[i].substring(0,1).toUpperCase() + wordList[i].substring(1);
//				result += wordList[i] + " ";
//				
//			}
//			else
//			{
//				result += wordList[i] + " ";
//			}
//			return result;