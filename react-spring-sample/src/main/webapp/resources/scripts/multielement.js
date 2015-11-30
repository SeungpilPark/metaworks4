var Commentlist = React.createClass({
    render: function () {
        return (
            React.createElement('div', {
                    className: "Commentlist",
                },
                "Hello, world! I am a CommentList."
            )
        );
    }
});
var CommentForm = React.createClass({
    render: function () {
        return (
            React.createElement('div', {
                    className: "Commentform",
                },
                "Hello, world! I am a CommentForm."
            )
        );
    }
});

var CommentBox = React.createClass({
    render: function () {
        return (
            React.createElement('div', {
                    className: "Commentbox",
                },
                React.createElement(Commentlist, null),
                React.createElement(CommentForm, null),
                React.createElement(Commentlist, null),
                React.createElement(CommentForm, null),
                React.createElement(Commentlist, null),
                React.createElement(CommentForm, null),
                React.createElement(Commentlist, null),
                React.createElement(CommentForm, null)
            )
        );
    }
});

ReactDOM.render(
    React.createElement(CommentBox, null),
    document.getElementById('content')
);

