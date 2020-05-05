import React from 'react';

interface Props {
  id: number;
  content: string;
  urgency: number;
  importance: number;
  done: boolean;
}
interface State {}

class Task extends React.Component<Props, State> {
  constructor(props: Props) {
    super(props);
  }

  render() {
    const {content, urgency, importance} = this.props; 
    return (
      <tr>
        <td>□</td>
        <td>{content}</td>
        <td>{urgency}</td>
        <td>{importance}</td>
      </tr>
    );
  }
}

export default Task;
