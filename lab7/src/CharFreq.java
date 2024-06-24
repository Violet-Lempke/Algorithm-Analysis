
/**
 * 
 * Basic data structure for a pair of data, a character and its frequency. 
 * 
 */
public class CharFreq {

    char character;
    int freq;

    CharFreq(char character, int freq) {
        this.character = character;
        this.freq = freq;

    }

    int compareTo(CharFreq friend) {

        if (this.freq > friend.freq) {
            return 1;
        }

        else if (this.freq == friend.freq) {

            return -1;

        }

        else {
            
            return 0;

        }
    }

    public void toScreen() {

        System.out.println(this.character + ": " + this.freq);
        
    }
}
