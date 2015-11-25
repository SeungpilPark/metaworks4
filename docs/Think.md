# 생각정리

#### 2015 11 25 수요일

리액트 튜토리얼을 진행해보고 소스코드를 올려본다.

UI 콤포넌트 객체지향 컨트롤러라는게 결론.

만일 이것을 쓴다면 Java 에서 리액트 스타일로 스크립트를 코드젠해서 제공해야 할텐데,

jsx 템플릿 코드젠 VS js 템플릿 코드젠 형식중 어떤방식을 취하는 것이 좋을지 사용자 입장에서 생각해본다...

템플릿 코드젠 코딩은 jsx 가 좋아보이는데... 너무 생소하단 말이지...

가급적 노멀하고 대중성 있는 언어만 숙지하여도 프로그래밍 할 수 있는 프레임워크를 만들고 싶고 다른 개념은 넣고 싶지 않다.

javascript, html, java, css 이 네가지만.


```
*jsx

var CommentBox = {};
CommentBox.bbb = React.createClass({
    render: function() {
        return (
                <div className="app">
                    <div className="new-status">
                        <h2>New monolog</h2>
                        <form action="">
                        <textarea /><br />
                        <input type="submit" value="Post" />
                        </form>
                    </div>

                    <div className="statuses">
                        <h2>Monologs</h2>
                        <ul></ul>
                    </div>
                </div>
        );
    }
});


ReactDOM.render(
<CommentBox.bbb />,
        document.getElementById('bbbb')
);

```

```
*js

var ExampleApplication = React.createClass({
        render: function() {
          var elapsed = Math.round(this.props.elapsed  / 100);
          var seconds = elapsed / 10 + (elapsed % 10 ? '' : '.0' );
          var message =
            'React has been successfully running for ' + seconds + ' seconds.';

          return React.DOM.p(null, message);
        }
      });

// Call React.createFactory instead of directly call ExampleApplication({...}) in React.render
var ExampleApplicationFactory = React.createFactory(ExampleApplication);

var start = new Date().getTime();
setInterval(function() {
ReactDOM.render(
  ExampleApplicationFactory({elapsed: new Date().getTime() - start}),
  document.getElementById('container')
);
}, 50);


```

