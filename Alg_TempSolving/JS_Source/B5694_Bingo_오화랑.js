const { DefaultDeserializer } = require('v8');

/*
알버트, 찰스, 메리는 고전 게임 빙고의 새로운 버전을 발명했습니다. 전통적인 빙고에서 이 게임은 호출자라고 알려진 비플레이어가 주재합니다. 
게임 초반에 각 플레이어는 0부터 N까지의 숫자들의 독특한 조합을 포함하는 열과 행으로 배열된 카드를 받습니다. 호출자는 0부터 N까지의 번호를 가진 N + 1개의 공이 들어 있는 가방을 가지고 있습니다. 
매 턴마다 호출자는 가방에서 무작위로 공을 선택하고, 그 공이 그려진 번호를 플레이어에게 공지한 후, 다시 선택할 수 없도록 공을 옆으로 둡니다. 각 플레이어는 호출된 번호를 찾기 위해 자신의 카드를 검색하고 그것을 찾으면 표시합니다. 
카드에 완전한 사전 공지 패턴을 표시한 첫 번째 플레이어가 상을 받습니다(예를 들어, 전체 수평선).

앨버트-찰스-매리 버전에서는 첫 번째 공을 뽑고, 다시 가방에 넣고, 두 번째 공을 뽑고, 다시 가방에 넣고, 두 공의 절대적인 차이를 불러냅니다. 
게임이 시작되기 전에 빈 공들의 부분집합을 가방에서 제거하여 적어도 두 개의 공이 남아 있도록 하는 방식으로 더욱 흥미를 유발합니다. 
그들은 가방에 남아 있던 공들을 고려하여 0부터 N까지의 모든 수를 여전히 새로운 추첨 방식으로 불러낼 수 있는지 알고 싶어합니다.

입력
각 테스트 케이스는 정확히 두 개의 라인을 사용하여 제공됩니다. 첫 번째 라인은 두 개의 정수 N과 B를 포함합니다. 
N의 의미는 위에서 설명한 것이고(1 ≤ N ≤ 90), B는 백(2 ≤ B ≤ N + 1)에 남아있는 공의 수를 나타냅니다. 두 번째 라인은 B개의 서로 다른 정수 bi를 포함하고 있으며, 백(0 ≤ bi ≤ N)에 남아있는 공을 나타냅니다.

마지막 테스트 케이스 뒤에 두 개의 0이 포함된 라인이 이어집니다.
출력
각 테스트 케이스에 대해 0부터 N까지의 모든 숫자를 호출할 수 있는 경우에는 하나의 대문자 'Y'를 포함하는 단일 행을 출력하고, 그렇지 않은 경우에는 하나의 대문자 'N'을 출력합니다.
*/
const input = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split('\n');
let result = new Array();
let idx = 0;
while (true) {
  let [N, B] = input[idx].split(' ');
  if (N == 0 && B == 0) break;

  let eachArray = input[idx + 1].split(' ');
  let combination = new Set();
  for (let i = 0; i < B - 1; i++) {
    for (let j = i + 1; j < B; j++) {
      combination.add(Math.abs(eachArray[j] - eachArray[i]));
    }
  }

  if (combination.size == N) result.push('Y');
  else result.push('N');
  idx += 2;
}
console.log(result.join('\n'));
