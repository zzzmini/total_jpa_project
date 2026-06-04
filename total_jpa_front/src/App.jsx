import "./App.css";
import Table from "react-bootstrap/Table";
import api from "./api";
import { useEffect, useState } from "react";

function App() {
  // 데이터 가져와서 사용할 state
  const [users, setUsers] = useState([]);

  // 처음 페이지가 로딩되면 DB에서 api 요청하기
  // localhost:8080/api
  useEffect(() => {
    api
      .get("/getPage?page=1&size=5")
      .then( (res) => {
          console.log(res)
        }
      )
      .catch((err) => {
        console.log(err)
      })
  }, []) // 1번만 실행

  return (
    <div>
      <h1>User 목록</h1>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>#</th>
            <th>Name</th>
            <th>email</th>
            <th>LikeColor</th>
            <th>생성일</th>
            <th>수정일</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td>
            <td>Mark</td>
            <td>a@b.c</td>
            <td>색깔</td>
            <td>yyyy-mm-dd</td>
            <td>yyyy-mm-dd</td>
          </tr>
        </tbody>
      </Table>
    </div>
  );
}

export default App;
