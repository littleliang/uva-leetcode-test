awk '{ for (i=1; i<=NF; i++) { ++S[$i]; } } END { for (i in S) { print i, S[i] } }' words.txt | sort -nr -k 2