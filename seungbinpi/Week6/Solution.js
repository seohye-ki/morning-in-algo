function solution(s) {
    
    let d = s.split(" ")
    
    let min = d[0]
    let max = d[0]
    for (let i=1; i<d.length; i++) {
        const tmp = parseInt(d[i])
        if (tmp < min) {
            min = tmp
        }
        if (tmp > max) {
            max = tmp
        }
    }
    
    return min + " " + max;
}